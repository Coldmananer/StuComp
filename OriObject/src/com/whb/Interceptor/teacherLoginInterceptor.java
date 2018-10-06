package com.whb.Interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.whb.Action.teacherLoginAction;

public class teacherLoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {

		// 对LoginAction不做该项拦截
        Object action = actionInvocation.getAction();
        if (action instanceof teacherLoginAction) {
            System.out.println("exit check login, because this is login action.");
            return actionInvocation.invoke();
        }
		
		Map session = actionInvocation.getInvocationContext().getSession();
		Object teacher = session.get("teacher");
		if(teacher != null){
			//System.out.println("already login!");
            return actionInvocation.invoke();
		}
		else{
			System.out.println("no login, forward login page!");
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("message", "请先登录");
            return Action.LOGIN;
		}
	}

}
