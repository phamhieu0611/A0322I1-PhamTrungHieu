package case_study.service.serviceImpl;

import case_study.action.ReadFile;
import case_study.action.WriteFile;
import case_study.models.person.Customer;

import java.util.LinkedHashMap;
import java.util.Map;

public class VoucherService {
    private static String FILE_VOUCHER = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\voucher.csv";
    private static final int VOUCHER_50=10;
    private static final int VOUCHER_20=10;
    private static CustomerServiceImpl customerService=new CustomerServiceImpl();
    private static Map<Integer,Integer> mapVoucher=new LinkedHashMap<>();

    public static int getVoucher(int customerId)
    {
        if(mapVoucher.get(customerId)==null)
            return 10;
        return mapVoucher.get(customerId);
    }

    public static void disPlay()
    {
        System.out.println("List Voucher: ");
        if(mapVoucher.size()!=0)
        {
            for (Map.Entry<Integer,Integer> entry:mapVoucher.entrySet())
            {
                Customer customer=customerService.getCustomer(entry.getKey());
                System.out.println("ID:"+entry.getKey()+", Name:"+customer.getName()+", Voucher: "+entry.getValue()+"%");
            }
        }
        else
        {
            System.out.println("Empty list!");
        }
    }

    public static void addToVoucher(int customerId)
    {
        Integer voucher;
        if(CustomerServiceImpl.getSize()<=VOUCHER_50)
        {
            mapVoucher.put(customerId,VOUCHER_50);
            voucher=VOUCHER_50;
        }
        else
        if(CustomerServiceImpl.getSize()<=(VOUCHER_20+VOUCHER_50))
        {
            mapVoucher.put(customerId,VOUCHER_20);
            voucher=VOUCHER_20;
        }
        else
        {
            voucher=10;
            mapVoucher.put(customerId,10);
        }
        writeVoucher(FILE_VOUCHER,customerId,voucher);
    }

    public static void writeVoucher(String path,Integer customerId,Integer voucher)
    {
        WriteFile.writeToFile(path,customerId,voucher);
    }

    public static void readVoucher(String path)
    {
        ReadFile.readDataFromVoucher(path,mapVoucher);
    }
}

