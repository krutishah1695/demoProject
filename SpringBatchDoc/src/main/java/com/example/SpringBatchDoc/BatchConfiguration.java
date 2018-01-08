package com.example.SpringBatchDoc;



import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.SpringBatchDoc.model.InterfaceData;
import com.example.SpringBatchDoc.model.InterfaceItemProcessor;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    // tag::readerwriterprocessor[]
    @Bean
    public FlatFileItemReader<InterfaceData> reader() {
        FlatFileItemReader<InterfaceData> reader = new FlatFileItemReader<InterfaceData>();
        reader.setResource(new ClassPathResource("interfaceDataDat.dat"));
        reader.setLineMapper(new DefaultLineMapper<InterfaceData>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "date", "fundCode","costCenter","naturalAccount","currency","accInfo","type","number","glas"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<InterfaceData>() {{
                setTargetType(InterfaceData.class);
            }});
        }});
        return reader;
    }

    @Bean
    public InterfaceItemProcessor processor() {
        return new InterfaceItemProcessor();
    }

   /*@Bean
    public JdbcBatchItemWriter<InterfaceData> writer() {
        JdbcBatchItemWriter<InterfaceData> writer = new JdbcBatchItemWriter<InterfaceData>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<InterfaceData>());
        writer.setSql("INSERT INTO InterfaceData (date_string, cost_center,fund_code,natural_account,currency,acc_Info,type_string,number,glas) VALUES (:date, :costCenter,:fundCode,:naturalAccount,:currency,:accInfo,:type,:number,:glas)");
        writer.setDataSource(dataSource);
        return writer;
    }*/
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<InterfaceData, InterfaceData> chunk(2)
                .reader(reader())
                .processor(processor())
                .writer(new BatchItemWriter())
                .build();
    }
    // end::jobstep[]
}