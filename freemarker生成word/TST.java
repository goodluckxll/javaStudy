



import java.io.*;

public class TST {


    public static void main(String[] args) {
        ABC a=new ABC("e:/zjzhgzh.docx","e:/");
//        ABC b=new ABC("d:/b.xls","d:/");
//        ABC c=new ABC("d:/c.xls","d:/");
//        ABC d=new ABC("d:/d.xls","d:/");
//        ABC e=new ABC("d:/e.xls","d:/");
//        ABC f=new ABC("d:/test.doc","d:/");
        a.run();
//        b.run();
//        c.run();
//        d.run();
//        e.run();
//        f.run();

    }


    static class ABC implements Runnable {
        public ABC(String source, String target) {
            this.source = source;
            this.target = target;
        }

        private String source;
        private String target;

        @Override
        public void run() {
            convertOffice2PDF(source, target);
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }


    }

    /**
     * 利用libreOffice将office文档转换成pdf
     *
     * @param inputFile 目标文件地址
     * @param pdfFile   输出文件夹
     * @return
     */
    public static boolean convertOffice2PDF(String inputFile, String pdfFile) {
        long start = System.currentTimeMillis();
        String command;
        boolean flag;
        String osName = System.getProperty("os.name");
        if (osName.contains("Windows")) {
            command = "cmd /c soffice --headless --invisible --convert-to pdf:writer_pdf_Export " + inputFile + " --outdir " + pdfFile;
        } else {
            command = "libreoffice --headless --invisible --convert-to pdf:writer_pdf_Export " + inputFile + " --outdir " + pdfFile;
        }
        flag = executeLibreOfficeCommand(command);
        long end = System.currentTimeMillis();
        System.out.println("用时:{} ms:" + (end - start));
        return flag;
    }

    public static boolean executeLibreOfficeCommand(String command) {
        System.out.println("开始进行转化.......");
        Process process;// Process可以控制该子进程的执行或获取该子进程的信息
        try {
            System.out.println("convertOffice2PDF cmd : {}" + command);
            process = Runtime.getRuntime().exec(command);// exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
            // 下面两个可以获取输入输出流
//            InputStream errorStream = process.getErrorStream();
//            InputStream inputStream = process.getInputStream();
        } catch (IOException e) {
            System.out.println(" convertOffice2PDF {} error" + command + e);
            return false;
        }
        int exitStatus = 0;
        try {
            exitStatus = process.waitFor();// 等待子进程完成再往下执行，返回值是子线程执行完毕的返回值,返回0表示正常结束
            // 第二种接受返回值的方法
            int i = process.exitValue(); // 接收执行完毕的返回值
            System.out.println("i----" + i);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException  convertOffice2PDF {}" + command + e);
            return false;
        }
        if (exitStatus != 0) {
            System.out.println("convertOffice2PDF cmd exitStatus {}" + exitStatus);
        } else {
            System.out.println("convertOffice2PDF cmd exitStatus {}" + exitStatus);
        }
        process.destroy(); // 销毁子进程
        System.out.println("转化结束.......");
        return true;
    }
}