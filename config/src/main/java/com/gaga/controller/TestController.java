package com.gaga.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

/**
 * demo
 *
 * @author ：liujia
 * @date ：Created in 2020/10/14 15:17
 * @version: 1.0
 */
public class TestController {


//    @Autowired
//    private DimShscYsszService dimShscYsszService;
//
//    @GetMapping("/getEntity")
//    @ResponseBody
//    public Object getEntity(HttpServletRequest request) throws Exception {
//
//        return ResultUtils.success(dimShscYsszService.getOne(new LambdaQueryWrapper<DimShscYssz>()
//                .eq(DimShscYssz::getGlyhmc, super.getUserFromSession(request).getUsername())
//                .eq(DimShscYssz::getJlzt, 0)
//        ));
//    }
//
//    @PostMapping("/save")
//    @ResponseBody
//    public Object save(HttpServletRequest request, @RequestBody DimShscYssz entity) throws Exception {
//
//        entity.setGlyhmc(super.getUserFromSession(request).getUsername());
//
//        boolean flag = dimShscYsszService.saveOrUpdate(entity);
//        if (flag) {
//            return ResultUtils.success(entity);
//        } else {
//            return ResultUtils.error(null);
//        }
//    }


    public static void main(String[] args) {

        long between = DateUtil.between(DateUtil.parse("20181114"), DateUtil.parse("2018-11-13"), DateUnit.DAY, false);
        System.out.println(between);
    }


}
