package com.zts.ceres.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FreemarkerGenerateWord {

    /**
     * @param dataMap      word中需要展示的动态数据，用map集合来保存
     * @param templateName word模板名称，例如：test.ftl
     * @param outFilePath  文件生成的目标路径，例如：D:/wordFile/
     * @param outFileName  生成的文件名称，例如：test.doc
     */
    @SuppressWarnings("unchecked")
    public static String createWord(Map dataMap, String templateName, String outFilePath, String outFileName) throws IOException {
        Writer out = null;
        try {
            long start = System.currentTimeMillis();
            //创建配置实例 
            Configuration configuration = new Configuration();
            //设置编码
            configuration.setDefaultEncoding("UTF-8");
            //ftl模板文件统一放至 com.lun.template 包下面
            configuration.setClassForTemplateLoading(FreemarkerGenerateWord.class, "/template/");
            //获取模板 
            Template template = configuration.getTemplate(templateName);
            //输出文件
            File outFile = new File(outFilePath + File.separator + outFileName);
            //如果输出目标文件夹不存在，则创建
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }
            //将模板和数据模型合并生成文件 
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
            //生成文件
            template.process(dataMap, out);
            //刷新流
            out.flush();
            long end = System.currentTimeMillis();
            System.out.println("freemarker生成word共耗时：" + ((end - start) / 1000.0) + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return "successed";
    }


    public static void main(String[] args) throws IOException {
        /** 用于组装word页面需要的数据 */
        Map<String, Object> dataMap = new HashMap<String, Object>();

        //signed --签约
        dataMap.put("signed", "true");
        //unsigned --解约
        dataMap.put("unsigned", "false");
        //threeParty --三方存管
        dataMap.put("threeParty", "true");
        //securitiesMarginTrading --融资融券
        dataMap.put("securitiesMarginTrading", "false");
        //bankDerivative --银衍签约
        dataMap.put("bankDerivative", "false");
        //bankFutures  --银期签约
        dataMap.put("bankFutures", "false");

        //escrowAccountName  --银行托管账户名称
        dataMap.put("escrowAccountName", "中泰证券股份有限公司");

        //escrowAccount  --银行托管账户账号
        dataMap.put("escrowAccount", "1234567890");

        //capitalAccount  --资金账号
        dataMap.put("capitalAccount", "1234567890");
        //capitalPassword  --资金密码
        dataMap.put("capitalPassword", "123456");

        //securitiesTrader --签约券商/期货营业部名称
        dataMap.put("securitiesTrader", "天津大华证券公司 北京证券营业部");

        //emergencyContact  --紧急联系人 电话
        dataMap.put("emergencyContact", "路飞 15712222222");
        //year  --年
        dataMap.put("year", "2020");
        //month  --月
        dataMap.put("month", "7");
        //day  --日
        dataMap.put("day", "21");
        /** 文件名称，唯一字符串 */
        Random r = new Random();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
        StringBuffer sb = new StringBuffer();
        sb.append(sdf1.format(new Date()));
        sb.append("_");
        sb.append(r.nextInt(100));
        //文件路径
        String outFilePath = "N:/";
        //文件唯一名称
        String outFileName = "freemarker.doc";
        /** 生成word */
        FreemarkerGenerateWord.createWord(dataMap, "capital_account_notice.ftl", outFilePath, outFileName);
    }
}
