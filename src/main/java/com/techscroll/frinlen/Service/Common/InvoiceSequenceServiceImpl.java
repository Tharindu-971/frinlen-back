package com.techscroll.frinlen.Service.Common;

import com.techscroll.frinlen.Entity.Common.InvoiceSequence;
import com.techscroll.frinlen.repository.Common.InvoiceSequenceRepository;
import com.techscroll.frinlen.repository.Invoice.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class InvoiceSequenceServiceImpl implements InvoiceSequenceService{

    @Autowired
    private InvoiceSequenceRepository invoiceSequenceRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public String getInvoiceSequence(){
        InvoiceSequence latestInvoiceSequence = invoiceSequenceRepository.findTopByOrderByIdDesc();
        String date =new SimpleDateFormat("ddMMyyyy").format(new Date());
        if(latestInvoiceSequence!=null){

            if(invoiceRepository.findByNumber(latestInvoiceSequence.getCode()+"".trim())!=null){
                int code = latestInvoiceSequence.getCode()+1;
                String prefix = "FIN";
                InvoiceSequence newInvoiceSequence = new InvoiceSequence().builder()
                        .code(code)
                        .prefix("FIN")
                        .date(date)
                        .number(prefix+date+code)
                        .build();

                String checkCode = newInvoiceSequence.getCode()+"";

                invoiceSequenceRepository.save(newInvoiceSequence);
                return newInvoiceSequence.getCode()+"";
            }else{
                return latestInvoiceSequence.getCode()+"";
            }



        }else{

            int code = 2366;
            String prefix = "FIN";
            InvoiceSequence newInvoiceSequence = new InvoiceSequence().builder()
                    .code(code)
                    .prefix("FIN")
                    .date(date)
                    .number(prefix+date+code)
                    .build();

            invoiceSequenceRepository.save(newInvoiceSequence);
            return newInvoiceSequence.getCode()+"";

        }
    }
}
