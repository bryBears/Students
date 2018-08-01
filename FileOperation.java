package cn.bear;

import java.io.*;
import java.util.*;

import static cn.bear.Test.room;

class FileOperation {
    private static String[] news = new String[100];
    private static int count;
    static void readFile(File file) {
        String[] str;
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                Student stu = new Student();
                result.append(System.lineSeparator() + s);
                str = s.split(" ");
                stu.setName(str[0]);
                stu.setScore(Double.parseDouble(str[1]));
                room.put(stu.getName(), stu.getScore());
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return result.toString();
    }
    static void menu() {
        int i;
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("1、计算品均分");
            System.out.println("2、排序并输出成绩");
            System.out.println("3、添加一个学生成绩");
            System.out.println("4、将数据保存到文件中");
            System.out.println("5、退出程序");
            System.out.print("请输入数字选择功能：");
            i = reader.nextInt();
            switch (i) {
                case 1:
                    getAvg();
                    break;
                case 2:
                    sortPrint();
                    break;
                case 3:
                    addScore();
                    break;
                case 4:
                    saveFile();
                    break;
                case 5:
                    exit();
                    break;
            }
        }
    }

    private static void getAvg() {
        System.out.println("平均分是。。。。");
        double totalScore = 0;
        Set<String> keys = room.keySet();
        for (String key : keys) {
            totalScore = room.get(key) + totalScore;
        }
        double avg = totalScore / room.size();
        System.out.println("平均分为：" + avg);
    }

    private static void sortPrint() {
        System.out.println("排查");
        Comparator<Map.Entry<String, Double>> valueComparator = (o1, o2) -> (int) (o2.getValue() - o1.getValue());
        List<Map.Entry<String, Double>> list = new ArrayList<>(room.entrySet());
        list.sort(valueComparator);
        for (Map.Entry<String, Double> entry : list) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }


    }

    private static void addScore() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要添加学生的名字");
        String name = scanner.next();
        news[count++] = name;
        System.out.println("请输入需要添加学生的成绩");
        double score = scanner.nextDouble();
        news[count++] = Double.toString(score);
        room.put(name, score);
    }


    private static void saveFile() {
        System.out.println("保存");

        File file = new File("C:\\Users\\Administrator\\Desktop\\data2.txt");

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
            for (int i = 0; i < count; i++) {
                if ((i % 2 == 0) && (news[i] != null)) {
                    out.write(news[i] + " ");
                } else if ((i % 2 == 1) && (news[i] != null)) {
                    out.write(news[i]);
                    out.newLine();

                }
            }
            for(int j=0;j<count;j++){
                news[j]=null;
            }
            out.close();
        } catch (IOException ignored) {
        }

    }

    private static void exit() {
        System.exit(0);
    }
}
