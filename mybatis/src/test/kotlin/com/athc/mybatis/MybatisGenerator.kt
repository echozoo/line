package com.athc.mybatis

import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.InjectionConfig
import com.baomidou.mybatisplus.generator.config.*
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder
import com.baomidou.mybatisplus.generator.config.po.TableInfo
import com.baomidou.mybatisplus.generator.config.rules.FileType
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import org.junit.jupiter.api.Test
import java.util.ArrayList

/**
 * @author jjj
 * @date 2020/9/16
 * @since JDK1.8
 */
class MybatisGenerator {

  @Test
  fun test() {
    // 代码生成器
    val mpg = AutoGenerator()

    // 全局配置
    val gc = GlobalConfig()
    val projectPath = "/Users/dujf/git_code/line/mybatis"
    gc.outputDir = "$projectPath/src/main/kotlin"
    gc.author = "jjj"
    gc.isOpen = false
    gc.isKotlin = true
    //实体属性 Swagger2 注解
    gc.isSwagger2 = true
    mpg.globalConfig = gc

    // 数据源配置
    val dsc = DataSourceConfig()
    dsc.url = "jdbc:mysql://localhost:3306/wolf?useUnicode=true&useSSL=false&characterEncoding=utf8"
    dsc.driverName = "com.mysql.cj.jdbc.Driver"
    dsc.username = "root"
    dsc.password = "123456"
    mpg.dataSource = dsc

    // 包配置
    val pc = PackageConfig()
    pc.parent = "com.athc.mybatis"
    mpg.packageInfo = pc

    // 自定义配置
    val cfg: InjectionConfig = object : InjectionConfig() {
      override fun initMap() {
        // to do nothing
      }
    }

    // 如果模板引擎是 freemarker
    val templatePath = "/templates/mapper.xml.ftl"
    // 如果模板引擎是 velocity
    // String templatePath = "/templates/mapper.xml.vm";

    // 自定义输出配置
    val focList: MutableList<FileOutConfig> = ArrayList<FileOutConfig>()
    // 自定义配置会被优先输出
    focList.add(object : FileOutConfig(templatePath) {
      override fun outputFile(tableInfo: TableInfo): String? {
        // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
        return (projectPath + "/src/main/resources/mapper/" + pc.moduleName
            + "/" + tableInfo.entityName + "Mapper.xml")
      }
    })
    cfg.fileOutConfigList = focList

    cfg.fileCreate = IFileCreate { _, _, _ -> true }
    mpg.cfg = cfg

    // 配置模板
    val templateConfig = TemplateConfig()
    // 不生成 controller service serviceImpl
    templateConfig.controller = null
    templateConfig.service = null
    templateConfig.serviceImpl = null
    // 配置自定义输出模板
    //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
    templateConfig.xml = null
    mpg.template = templateConfig

    // 策略配置
    val strategy = StrategyConfig()
    strategy.naming = NamingStrategy.underline_to_camel
    strategy.columnNaming = NamingStrategy.underline_to_camel
    strategy.isEntityLombokModel = true
    strategy.isRestControllerStyle = true
//    strategy.setSuperEntityColumns("id")
    strategy.setInclude("goods", "goods_order")
    strategy.isControllerMappingHyphenStyle = true
    strategy.setTablePrefix(pc.moduleName + "_")
    mpg.strategy = strategy
    mpg.templateEngine = FreemarkerTemplateEngine()
    mpg.execute()
  }
}