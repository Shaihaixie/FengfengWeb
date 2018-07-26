<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title></title>
	<style>

        ::-webkit-scrollbar {
            display: none;
        }

        #container { 
            width: 50%;
            height:400px;
             overflow: scroll;
            border: 1px springgreen solid; 
           padding: 10px;
           background-color: aqua;
        }
        #fs{  width: 100%;}
        
   #dakuang{
    width: 100%;
    height:300px;
   diaplay:"flex";
   flex-flow: column;
   justify-content: center;
   }
   
     .add-loading {
            background-image: url(img/loading-1.gif);
            background-repeat: no-repeat;
            background-position: center;
            /*background-size: cover;*/

        }
   
    </style>
</head>
<body>
  
  
  <div id="dakuang">
    <div id="container">
       </div>
     <div id="fs">
         <input id="pname" value="商品名" >
         <input id="pdesc" value="商品描述">
          <input id="price" value="商品价格">
         <input id="btn" type="button" value="send">
     </div>
     <input id="btn2" type="button" value="排序">
</div>
           
</body>
</html>
 <script src="assets/js/jquery-3.3.1.min.js"></script>
<script>
    $(function(){

    	 $("#btn").click(function(){

             var pname = $("#pname").val();
             var pdesc = $("#pdesc").val();
             var price=$("#price").val();

             $.ajax({
                 type : 'post' ,
                 url : 'http://localhost:8080/FengSHOP/view/product?operation=1&pname='+pname+'&pdesc='+pdesc+'&price='+price,
                 success : function(){
                     $("#container").append($("<div class='sss'>"+pname+"   "+pdesc+"   "+price+" </div>"))
                     $("#pname").val("");
                    $("#pdesc").val("");
                    $("#price").val("");
                 },
                 beforeSend : function(){
                     $("#container").removeClass('add-loading')
                 }
             })
         })  
          $("#btn2").click(function(){
        	  $("#container").empty()
             $.ajax({
                 type : 'post' ,
                 url : 'http://localhost:8080/FengSHOP/view/product?operation=7',
                	 dataType : 'json' ,
                     success : function(data) {
                         $.each(data,function(i,e){
                          var item=$("<div >"+e.name+"   "+e.desc+"   "+e.price+"</div>")
                          $("#container").append(item);
                                })
                     },
                 beforeSend : function(){
                     $("#container").remove('sss')
                 }
             })


         })        
        $.ajax({
            type :'post',
            url : 'http://localhost:8080/FengSHOP/view/product?operation=2&pageNo=1&pageSize=5',
            dataType : 'json' ,
            success : function(data) {
                $.each(data.data,function(i,e){
                 var item=$("<div>"+e.id+e.name+"   "+e.desc+"   "+e.price+"</div>")
                   var remove=$("<span>删除</span>")
                 $("#container").append(item);
                 $(item).append(remove);       
                 remove.click(function(){
                	    item.remove();
                	    $(this).remove();
                	    $.ajax({
                	        url:'http://localhost:8080/FengSHOP/view/product?operation=3&id='+e.id,
                	        type:'get',
                	        success:function(){
                	            alert("删除成功！")
                	        }
                	    })
                	})       
                       })
            },
            beforeSend : function(){
                $("#container").addClass('add-loading')
            }
            

        }
        )
    })

</script>