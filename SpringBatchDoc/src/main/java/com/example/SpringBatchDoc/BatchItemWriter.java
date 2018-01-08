package com.example.SpringBatchDoc;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.example.SpringBatchDoc.model.InterfaceData;

public class BatchItemWriter implements ItemWriter<InterfaceData>{
	
	//@Override
		public void write(List<? extends InterfaceData > interfaceData) throws Exception {
			int i=0;
			System.out.println("Objects ");
			for(i=0;i<interfaceData.size();i++){
				System.out.println(interfaceData.get(i));
				
			}
		}

}
