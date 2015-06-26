/**
 * 
 */

Ext.onReady(function() {
	
	
	
	
	
	function tabs(node){
		
	}
	
	Ext.create('Ext.Viewport', {
		layout : {
			type : 'border',
			padding : 5
		},
		items : [ {
			xtype : 'container',
			region : 'north',
			height : 55,
			items : [ {
				xtype : 'panel',
				height : 50,
				layout : 'border',
				bodyStyle : {
					background : '#fff'
				},
				buttonAlign : 'right',
				items : [ {
					region : 'west',
					xtype : 'image',
					src : '../publicAssets/images/logo.png',
					padding : 3,
					border : false,
					minWidth : 400
				}, {
					region : 'east',
					xtype : 'panel',
					minWidth : 200,
					border : false,
					padding : 10,
					layout : 'auto',
					items : [ {
						xtype : 'button',
						padding : 3,
						text : '锁定系统'
					} ]
				} ]
			} ]

		}, {

			region : 'west',
			split : true,
			width : 200,
			title : '功能',
			frame : true,
			collapsible : true,
			minWidth : 100,
			layout : 'accordion',
			items : [ {
				title : '产品管理',
				xtype : 'treepanel',
				rootVisible : false,
				listeners:{
					click:{
						element:'el',
						fn:function(node){
							tabs(node);
						}
					}
				},
				root : {
					text : 'root',
					id : 'rootProduct',
					expanded : true,
					children : [ {
						text : '产品管理',
						id : 'product',
						leaf : true
					}, {
						text : '统计管理',
						id : 'stat',
						leaf : true
					} ]
				}
			}, {
				title : "系统管理",
				xtype : "treepanel",
				rootVisible : false,
				root : {
					text : 'root',
					id : 'rootSyetem',
					expanded : true,
					children : [ {
						text : "用户管理",
						id : "User",
						leaf : true
					}, {
						text : "系统设置",
						id : "System",
						leaf : true
					} ]
				}

			} ]
		}, {
			region : 'center',
			xtype : 'tabpanel',
			id:'mainTabPanel',
			split : true,
			layout:'fit',
			/*items : [ {
				title : "桌面",
				closable : false,
				html:'<iframe src="tab.html" height="100%" width="100%" frameBorder="0" style="border:none;"></iframe>',
				padding:5
			} ]*/
			items:[
			       {
			    	   title:'桌面',
			    	   closeable:false,
			    	   padding:5,
			    	   loader:{
			    		   autoLoad:true,
			    		   url:'tab.html',
			    		   scripts:true
			    	   }
			       }
			       ]
		} ]
	})
})