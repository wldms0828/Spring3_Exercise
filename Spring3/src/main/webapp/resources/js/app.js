"use strict";
var app = app || {};
var user = user || {};
app = {
	init : x=>{
		console.log('step 1');
		app.session.context(x);
		app.onCreate();
	},
	onCreate : ()=>{
		console.log('step 3 ::');
		app.setContentView();
		$('#login__btn').click(()=>{
			location.href = app.x()+'/move/auth/member/login';
		});
		$('#join__btn').click(()=>{
			location.href = app.x()+'/move/auth/member/add';
		});
		$('#login__submit').click(()=>{
			alert('login__submit click!!');
			$('#login__form')
			.attr({
				action : app.x()+'/member/login',
				method : "POST"
			})
			.submit();
		});
		$('#mypage__btn').click(()=>{
			alert('mypage__btn click');
			location.href=app.x()+'/member/retrieve/'+userid;
		});
		$('#logout__btn').click(()=>{
			alert('logout');
			location.href = app.x()+'/member/logout';
		});
		$('#add_submit').click(()=>{
			alert('add_submit click!!');	
			$('#add_form')
			.attr({
				action: app.x()+"/member/add",
				method : "POST"
			})
			.submit();
/*
			var form = document.getElementById('add_form');
			form.action = app.x()+"/member/add";
			form.method = "POST";
			form.submit();
*/
		});
		$('#delete__btn').click(()=>{
			alert('delete__btn click!!');
			location.href = app.x()+'/move/delete/member/remove';
			
		});
		$('#deleteFormBtn').click(()=>{
			alert('deleteFormBtn!!');
			$('#deleteForm')
			.attr({
				action : app.x()+"/member/remove",
				mothod : "POST"
			})
			.submit();
		});
		$('#update__btn').click(()=>{
			alert('modifyBtn click!!');
			location.href = app.x()+'/move/update/member/modify';
		});
		$('#modifyBtn').click(()=>{
			alert('update__btn click!!');
			$('#updateForm')
			.attr({
				action : app.x()+"/member/modify",
				method : "POST"
			})
			.submit();
		});
	},
	setContentView : ()=>{
		console.log('step 4 ::'+app.j());
	}
};
app.session = {
	context : x=>{
		console.log('step 2 ::'+x);
		sessionStorage.setItem('context',x);
		sessionStorage.setItem('js',x+'/resources/js');
		sessionStorage.setItem('css',x+'/resources/css');
		sessionStorage.setItem('img',x+'/resources/img');
	},
	path : x=>{
		return sessionStorage.getItem(x);
	}
};
app.x = ()=>{
	return app.session.path('context');
};
app.j = ()=>{
	return app.session.path('js');
};
app.c = ()=>{
	return app.session.path('css');
};
app.i = ()=>{
	return app.session.path('img');
};

user.session= x => {
		$.each(x, function(k,v){
			alert('key:'+k+',value:'+v);
			sessionStorage.setItem(k, v);
		});
		alert(sessionStorage.getItem('userid'));
		
};





