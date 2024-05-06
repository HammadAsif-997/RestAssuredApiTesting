package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name="Data")
    public String[][] getAllData() throws IOException
    {
//        String path=System.getProperty("user.dir")+ "/Testdata/Userdata.xlsx";
        String path= "./src/test/resources/Userdata.xlsx";
        XLUtility xl=new XLUtility(path);

        int rownum=xl.getRowCount("Sheet1");
        int colcount=xl.getCellCount("Sheet1",1);

        String apidata[][]=new String[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
            }
        }

        return apidata;
    }


    @DataProvider(name="FirstNames")
    public String[] getUserNames() throws IOException
    {
        String path=System.getProperty("user.dir")+"//testData//Userdata.xlsx";
        XLUtility xl=new XLUtility(path);

        int rownum=xl.getRowCount("Sheet1");

        String apidata[]=new String[rownum];
        for(int i=1;i<=rownum;i++)
        {
            apidata[i-1]=xl.getCellData("Sheet1", i, 1);
        }

        return apidata;

    }

    @DataProvider(name="UserID")
    public String[] getUserIds() throws IOException
    {
        String path=System.getProperty("user.dir")+"//testData//Userdata.xlsx";
        XLUtility xl=new XLUtility(path);

        int rownum=xl.getRowCount("Sheet1");

        String apidata[]=new String[rownum];
        for(int i=1;i<=rownum;i++)
        {
            apidata[i-1]=xl.getCellData("Sheet1", i, 0);
        }

        return apidata;

    }
}