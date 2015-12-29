import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Vic on 2015/12/26.
 */
public class TestAssignCase {

    private static class AssignRec {
        public String companyCd;
        public int totalNum;
        public int currentNum;
    }

    /**
     * 获得外包电催公司ID
     *
     * @param oldCompanyCd 上次委外的外包电催公司ID
     * @param assignRecs   委外对象
     * @return 外包电催公司ID
     */
    public String getAssignedCompanyCd(String oldCompanyCd, List<AssignRec> assignRecs) {
        // 分曾经委外过的案件
        for (AssignRec r : assignRecs) {
            if (r.currentNum < r.totalNum && !r.companyCd.equals(oldCompanyCd)) {
                r.currentNum++;
                oldCompanyCd = getRandomEntrustCompanyCd(oldCompanyCd, assignRecs);
                if (oldCompanyCd == null || "".equals(oldCompanyCd)) {
                    break;
                }
                return oldCompanyCd;
            }
        }

        // 分未委外过的案件
        if (oldCompanyCd == null || "".equals(oldCompanyCd)) {// 委外新案件
            for (AssignRec r : assignRecs) {
                if (r.currentNum < r.totalNum) {
                    r.currentNum++;
                    return r.companyCd;
                }
            }
        }

        //// 查漏补全
        //for (AssignRec r : assignRecs) {
        //    if (r.currentNum == r.totalNum) {
        //        continue;
        //    }
        //    return getAssignedCompanyCd("", assignRecs);
        //}
        return null;
    }

    /**
     * 当委外已经委外过的案件时随机分配委外公司ID
     *
     * @param oldCompanyCd 已委外过的公司ID
     * @param assignRecs   待委外的集合
     * @return 新委外的公司Id
     */
    public String getRandomEntrustCompanyCd(String oldCompanyCd, List<AssignRec> assignRecs) {
        int n = new Random().nextInt(assignRecs.size());// n in [0, assignRecs.size()]
        System.out.println("random n: " + n);
        String companyCd = assignRecs.get(n).companyCd;
        if (!oldCompanyCd.equals(companyCd)) {
            return companyCd;
        }
        return "";
    }

    public void assignCase() {
        List<String> keys = new ArrayList<>();

        List<AssignRec> assignRecs = new ArrayList<>();
        Map<String, BigDecimal> mapNum = new HashMap<>();
        initMap(mapNum);
        Set<String> keySet = mapNum.keySet();
        initAssignRecs(assignRecs, mapNum, keySet);

        //已分案过的案件
        List entrustedList = initEntrustedList();
        for (Object obj : entrustedList) {
            Object[] caseNos = (Object[]) obj;
            String caseNo = caseNos[0] != null ? caseNos[0].toString() : "";
            String oldCompanyCd = caseNos[1] != null ? caseNos[1].toString() : "";
            String companyCd = getAssignedCompanyCd(oldCompanyCd, assignRecs);
            keys.add(caseNo + "-" + companyCd);
        }
        //未分案过的案件
        List entrustList = initEntrustList();
        for (Object obj : entrustList) {
            String companyCd = getAssignedCompanyCd("", assignRecs);
            keys.add(obj.toString() + "-" + companyCd);
        }

        print(keys, mapNum);
    }

    private static void initAssignRecs(List<AssignRec> assignRecs, Map<String, BigDecimal>
            mapNum, Set<String> keySet) {
        for (String key : keySet) {
            AssignRec assignRec = new AssignRec();
            assignRec.currentNum = 0;
            assignRec.totalNum = mapNum.get(key).intValue();
            assignRec.companyCd = key;
            assignRecs.add(assignRec);
        }
    }

    private void print(List<String> keys, Map<String, BigDecimal> mapNum) {
        Set<String> keySet2 = mapNum.keySet();
        for (String key : keySet2) {
            int count = 0;
            for (String key2 : keys) {
                if (key.equals(key2.split("-")[1])) {
                    count++;
                }
            }
            System.out.println(key + "公司应分：" + mapNum.get(key) + " 实分：" + count);
        }


        System.out.println("分案明细");
        for (String str : keys) {
            System.out.println(str);
        }
    }

    private List<Object> initEntrustedList() {
        List<Object> list = new ArrayList<>();

        list.add(new String[]{"1", "101"});
        list.add(new String[]{"2", "101"});
        list.add(new String[]{"3", "101"});
        list.add(new String[]{"4", "101"});
        list.add(new String[]{"5", "101"});
        list.add(new String[]{"6", "101"});
        list.add(new String[]{"7", "101"});
        list.add(new String[]{"8", "101"});
        list.add(new String[]{"9", "101"});
        list.add(new String[]{"10", "101"});

        return list;
    }

    private List<String> initEntrustList() {
        List<String> list = new ArrayList<>();

        for (int i = 11; i <= 60; i++) {
            list.add(i + "");
        }
        return list;
    }


    public void initMap(Map<String, BigDecimal> mapNum) {
        mapNum.put("101", new BigDecimal(30));
        mapNum.put("102", new BigDecimal(10));
        mapNum.put("103", new BigDecimal(20));

    }

    public static void main(String[] args) {
        TestAssignCase assignCase = new TestAssignCase();
        //assignCase.assignCase();

        List<AssignRec> assignRecs = new ArrayList<>();
        Map<String, BigDecimal> mapNum = new HashMap<>();
        assignCase.initMap(mapNum);
        Set<String> keySet = mapNum.keySet();
        initAssignRecs(assignRecs, mapNum, keySet);

        System.out.println(assignCase.getRandomEntrustCompanyCd("101", assignRecs));
    }
}
