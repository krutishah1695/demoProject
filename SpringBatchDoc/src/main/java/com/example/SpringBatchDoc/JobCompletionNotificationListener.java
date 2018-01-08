package com.example.SpringBatchDoc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.SpringBatchDoc.model.InterfaceData;


@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("JOBExceution" + jobExecution.getStatus());
		System.out.println("BatchStatus" + BatchStatus.COMPLETED);
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");

			List<InterfaceData> results = jdbcTemplate.query("SELECT date_string,cost_center,fund_code,natural_account,currency,acc_Info,type_string,number,glas from interfaceData", new RowMapper<InterfaceData>() {
				@Override
				public InterfaceData mapRow(ResultSet rs, int row) throws SQLException {
					return new InterfaceData(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getLong(8),rs.getString(9));
				}
			});

			for (InterfaceData interfaceData: results) {
				log.info("Found <" + interfaceData + "> in the database.");
			}

		}
	}
}