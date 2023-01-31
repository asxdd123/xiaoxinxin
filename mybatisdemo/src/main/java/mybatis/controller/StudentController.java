package mybatis.controller;

import com.github.pagehelper.PageInfo;
import mybatis.entry.Studnt;
import mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-25 19:00
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    /**
     * 单表CRUD
     */
    @Autowired
    private StudentService studentService;

    Logger logger = Logger.getLogger("mybatis.mapper.StudentMapper");

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/aa")
    public PageInfo<Studnt> selectList() {
        return studentService.selectList();
    }

    /**
     * 基于参数封装成Map结构带入XML中查询
     * @param map
     * @return
     */
    @RequestMapping("/as")
    public Studnt selectByIdAndName(@RequestBody Map<String, Object> map) {
        return studentService.selectByIdAndName(map);
    }

    /**
     * 新增一条数据
     *
     * @param studnt
     * @return
     */
    @RequestMapping("/bb")
    public int insertStudent(@RequestBody Studnt studnt) {
        return studentService.insertStudent(studnt);
    }

    /**
     * 单个条件查询
     *
     * @param id
     * @return
     */
    @RequestMapping("/ee")
    public Studnt selectById(@RequestParam("id") String id) {
        return studentService.selectById(id);
    }


    /**
     * 多条件查询
     *
     * @param sex
     * @param name
     * @return
     */
    @RequestMapping("/ff")
    public List<Studnt> selectBySexAndName(@RequestParam("sex") String sex, @RequestParam("name") String name) {
        return studentService.selectBySexAndName(sex, name);
    }

    /**
     * 修改单条数据
     *
     * @param studnt
     * @return
     */
    @RequestMapping("/gg")
    public int updateSrudent(@RequestBody Studnt studnt) {
        return studentService.updateSrudent(studnt);
    }

    /**
     * 删除单条
     *
     * @param id
     * @return
     */
    @RequestMapping("/hh")
    public int deleteSrudent(@RequestBody String id) {
        return studentService.deleteSrudent(id);
    }

    /**
     * 根据条件批量删除
     *
     * @param name
     * @param sex
     * @return
     */
    @RequestMapping("/qq")
    public int deleteSrudentByNameAndSex(@RequestParam("name") String name, @RequestParam("sex") String sex) {
        return studentService.deleteSrudentByNameAndSex(name, sex);
    }


    /**
     * 测试新增一万条数据执行程序时间(短)  2秒  批量执行尽量使用<foreach></foreach> 批量修改同理
     *
     * @return
     * @throws ParseException
     */
    @RequestMapping("/cc")
    public int insertStudentList() throws ParseException {
        List<Studnt> studnts = new ArrayList<>();
        for (int i = 45; i <= 10045; i++) {
            Studnt studnt = new Studnt();
            studnt.setSid(String.valueOf(i));
            studnt.setSname("aaaaa");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = "2023-01-28";
            Date parse = dateFormat.parse(date);
            studnt.setSage(parse);
            studnt.setSsex("男");
            studnt.setUrl("aa");

            studnts.add(studnt);
        }
        logger.info("学生总数=" + studnts.size());


        long millis = System.currentTimeMillis();
        logger.info("批量新增开始时间:" + millis);
        int i = studentService.insertStudentList(studnts);
        long timeMillis = System.currentTimeMillis();
        logger.info("批量新增结束时间:" + timeMillis);

        long time = (timeMillis - millis);
        logger.info("耗时" + time + "毫秒");
        logger.info("耗时" + TimeUnit.MILLISECONDS.toSeconds(time) + "秒");
        logger.info("耗时" + TimeUnit.MILLISECONDS.toMinutes(time) + "分");
        return i;
    }

    /**
     * 测试新增一万条数据执行程序时间(长)   19秒
     *
     * @return
     */
    @RequestMapping("/dd")
    public void insertStudentList02() {
        try {
            long millis = System.currentTimeMillis();
            logger.info("执行开始时间:" + millis);
            for (int i = 10046; i <= 20046; i++) {
                Studnt studnt = new Studnt();
                studnt.setSid(String.valueOf(i));
                studnt.setSname("aaaaaaa");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = "2023-01-28";
                Date parse = dateFormat.parse(date);
                studnt.setSage(parse);
                studnt.setSsex("男");
                studnt.setUrl("bb");

                insertStudent(studnt);
            }
            long timeMillis = System.currentTimeMillis();
            logger.info("执行结束时间:" + timeMillis);
            long time = (timeMillis - millis);
            logger.info("耗时" + time + "毫秒");
            logger.info("耗时" + TimeUnit.MILLISECONDS.toSeconds(time) + "秒");
            logger.info("耗时" + TimeUnit.MILLISECONDS.toMinutes(time) + "分");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
