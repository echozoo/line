package com.athc.web.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 班级课程安排信息：eas_course_schedule
 * </p>
 *
 * @author dujf
 * @since 2018-05-17
 */
@TableName("eas_course_schedule")
public class EasCourseSchedule extends Model<EasCourseSchedule> {

    private static final long serialVersionUID = 1L;

    @TableId("schedule_id")
    private Integer scheduleId;
    @TableField("school_year")
    private Integer schoolYear;
    private Integer semaster;
    @TableField("course_code")
    private String courseCode;
    @TableField("course_name")
    private String courseName;
    private String credit;
    @TableField("academy_code")
    private String academyCode;
    @TableField("academy_name")
    private String academyName;
    @TableField("classroom_code")
    private String classroomCode;
    @TableField("classroom_name")
    private String classroomName;
    private String classcode;
    private String weeks;
    private String weekly;
    private String classes;
    private String teachercode;
    private String teachername;
    @TableField("weeks_analyse")
    private String weeksAnalyse;


    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Integer getSemaster() {
        return semaster;
    }

    public void setSemaster(Integer semaster) {
        this.semaster = semaster;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getAcademyCode() {
        return academyCode;
    }

    public void setAcademyCode(String academyCode) {
        this.academyCode = academyCode;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getClassroomCode() {
        return classroomCode;
    }

    public void setClassroomCode(String classroomCode) {
        this.classroomCode = classroomCode;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    public String getWeekly() {
        return weekly;
    }

    public void setWeekly(String weekly) {
        this.weekly = weekly;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getTeachercode() {
        return teachercode;
    }

    public void setTeachercode(String teachercode) {
        this.teachercode = teachercode;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getWeeksAnalyse() {
        return weeksAnalyse;
    }

    public void setWeeksAnalyse(String weeksAnalyse) {
        this.weeksAnalyse = weeksAnalyse;
    }

    public static final String SCHEDULE_ID = "schedule_id";

    public static final String SCHOOL_YEAR = "school_year";

    public static final String SEMASTER = "semaster";

    public static final String COURSE_CODE = "course_code";

    public static final String COURSE_NAME = "course_name";

    public static final String CREDIT = "credit";

    public static final String ACADEMY_CODE = "academy_code";

    public static final String ACADEMY_NAME = "academy_name";

    public static final String CLASSROOM_CODE = "classroom_code";

    public static final String CLASSROOM_NAME = "classroom_name";

    public static final String CLASSCODE = "classcode";

    public static final String WEEKS = "weeks";

    public static final String WEEKLY = "weekly";

    public static final String CLASSES = "classes";

    public static final String TEACHERCODE = "teachercode";

    public static final String TEACHERNAME = "teachername";

    public static final String WEEKS_ANALYSE = "weeks_analyse";

    @Override
    protected Serializable pkVal() {
        return this.scheduleId;
    }

}
