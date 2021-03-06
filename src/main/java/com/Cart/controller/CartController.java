package com.Cart.controller;


import com.Medicine.service.MedicineService;
import com.entity.Cart;
import com.entity.Medicine;
import com.entity.MyCart;
import com.google.gson.Gson;
import com.Cart.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
@Api("购物车服务器")
public class CartController {

    @Resource
    CartService cartService;
    @Resource
    MedicineService medicineService;
    Gson gson = new Gson();

    //获取所有购物车信息
    @ApiOperation("获取所有购物车信息")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list()
    {
        List<Cart> cartList = this.cartService.findAll();
        String result = gson.toJson(cartList);
        return result;
    }

    //根据UserId查询购物车信息
    @ApiOperation("根据UserId查询购物车信息")
    @RequestMapping(value = "/findByUserId",method = RequestMethod.GET)
    public String findByUserId(@RequestParam("userId")int userId){
        List<Cart> cartList = this.cartService.findByUserId(userId);
        List<MyCart> myCartList = new ArrayList<>();
        Medicine medicine = null;
        for (int i= 0;i<cartList.size();i++) {
            MyCart myCart = new MyCart();
            Cart c= cartList.get(i);
            System.out.println(c.getId()+"\n"+c.getMedicineId()+"\n");
            medicine = this.medicineService.findById(c.getMedicineId());
            myCart.setUserId(c.getUserId());
            myCart.setCount(c.getCount());
            myCart.setId(c.getId());
            myCart.setName(medicine.getMedicine());
            myCart.setImg(medicine.getImg1());
            myCart.setStandard(medicine.getStandard());
            myCart.setPrice(c.getPrice());
            myCart.setStatus(c.getStatus());
            myCart.setMedicineId(medicine.getId());
            myCartList.add(i,myCart);
        }
        String result = gson.toJson(myCartList);
        System.out.println(result);
        return result;
    }

    //增加购物车
    @ApiOperation("添加购物车")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("json")String json){
        try{
            Cart cart = gson.fromJson(json,Cart.class);
            this.cartService.add(cart);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }
    //根据ID删除购物车
    @ApiOperation("移出购物车")
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(@RequestParam("id")int id){
        try{
            this.cartService.delete(id);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //更改购物车
    @ApiOperation("更新购物车")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestParam("json")String json){
        try{
            this.cartService.add(gson.fromJson(json,Cart.class));
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //批量删除
    @ApiOperation("批量删除购物车")
    @RequestMapping(value = "/deleteList",method = RequestMethod.POST)
    public String deleteIn(@RequestParam("ids") String ids){
        try{
            //把字符串前后多余的空格去掉
            ids.trim();
            String[] list_id = ids.split(",");
            List<Integer> list = new ArrayList<Integer>();
            for(String id : list_id) {
                list.add(Integer.parseInt(id));
            }
            this.cartService.deleteInBatch(list);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //根据UserId删除
    @PostMapping("/deleteByUserId")
    public String deleteByUserId(@RequestParam("userId")int userId){
        try{
            //把字符串前后多余的空格去掉
            this.cartService.deleteByUserId(userId);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }
}