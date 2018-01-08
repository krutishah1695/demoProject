package com.example.SpringBatchDoc.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class InterfaceItemProcessor implements ItemProcessor<InterfaceData, InterfaceData> {

    private static final Logger log = LoggerFactory.getLogger(InterfaceItemProcessor.class);

    @Override
    public InterfaceData process(final InterfaceData interfaceData) throws Exception {
        final String date = interfaceData.getDate().toUpperCase();
        final String costCenter =interfaceData.getCostCenter().toUpperCase();
        final String fundCode=interfaceData.getFundCode().toUpperCase();
        final String naturalAccountNumber=interfaceData.getNaturalAccount().toUpperCase();
        final String currency=interfaceData.getCurrency().toUpperCase();
        final String accInfo=interfaceData.getAccInfo().toUpperCase();
        final String type=interfaceData.getType().toUpperCase();
        final long number=interfaceData.getNumber();
        final String glas=interfaceData.getGlas().toUpperCase();
        
        
        
        final InterfaceData transformedInterface = new InterfaceData(date,fundCode,costCenter,naturalAccountNumber,currency,accInfo,type,number,glas);

        log.info("Converting (" + interfaceData + ") into (" + transformedInterface + ")");

        return transformedInterface;
    }

}