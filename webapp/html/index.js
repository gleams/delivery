/**
 * 
 */

Ext.onReady(function(){
	Ext.create('Ext.Viewport',{
		layout:{
			type:'border',
			padding:5
		},
		items:[
		       {
			    	xtype:'container',
			    	region:'north',
			    	height:40
		       },
		       {
		    	   
		    	   region:'west',
		    	   split:true,
		    	   width:200,
		    	   title:'功能',
		    	   frame:true,
		    	   collapsible:true,
		    	   minWidth:100,
		    	   layout:'accordion',
		    	   items:[
		    	          {
		    	        	  title:'产品管理',
		    	        	  xtype:'treepanel',
		    	        	  rootVisible:false,
			   		    	   root:{
			   		    		   text:'root',
			   		    		   id:'rootProduct',
			   		    		   expanded:true,
			   		    		   children:[
			   		    		             {text:'产品管理',
			   		    		            	id:'product',
			   		    		            	leaf:true
			   		    		             },
			   		    		             {
			   		    		            	 text:'统计管理',
			   		    		            	 id:'stat',
			   		    		            	 leaf:true
			   		    		             }
			   		    		             ]
		    	          
			   		    	   }
		    	          },
		    	          {title:"系统管理",xtype:"treepanel",
								rootVisible: false,
						        root: {
						            text: 'root',id: 'rootSyetem',
          						expanded: true,children:[
	          							{text:"用户管理",id:"User",leaf:true},
	          							{text:"系统设置",id:"System",leaf:true}
          							]
						        }
      						
							}
		    	          ]
		       },
		       {
		    	   region:'center',
		    	   xtype:"tabpanel",
					split:true,
					width:200,
					minWidth:100,
					items:[
						{title:"快捷桌面",closable:false}
					]
		       }
		       ]
	})
})