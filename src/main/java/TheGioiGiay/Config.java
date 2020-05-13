/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGioiGiay;

import org.apache.commons.lang.SystemUtils;

/**
 *
 * @author ASUS
 */
public class Config {
    public static String site = "https://thegioigiay.com/";   
//    public static String site = "http://nguyennam.shopbay.test";

    public static String getDriver()
    {
        String result = "";
        
        String osName = System.getProperty("os.name");
        
        if (SystemUtils.IS_OS_LINUX) {
            result = "/usr/bin/google-chrome";
        } else if (SystemUtils.IS_OS_WINDOWS) {
            result = "D:\\drivers\\chromedriver.exe";
        }

        return result;
    }
}
