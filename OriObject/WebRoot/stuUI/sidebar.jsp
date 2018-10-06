<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
    <aside class="app-sidebar">
      <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="https://s3.amazonaws.com/uifaces/faces/twitter/jsa/48.jpg" alt="User Image">
        <div>
          <p class="app-sidebar__user-name">${student.stuName}</p>
          <p class="app-sidebar__user-designation">学生</p>
        </div>
      </div>
      <ul class="app-menu">
      
         <li><a class="app-menu__item active" href="stuUI/stuIndex.jsp"><i class="app-menu__icon fa fa-dashboard"></i><span class="app-menu__label">主页</span></a></li>
        <li class="treeview"><a class="app-menu__item" href="javascript:;" data-toggle="treeview" ><i class="app-menu__icon fa fa-laptop"></i><span class="app-menu__label">所有竞赛项目</span><i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul>
            <li><a class="treeview-item" href="showAplComp?page=1"><i class="icon fa fa-circle-o"></i>报名中的竞赛</a></li>
            <li><a class="treeview-item" href="showRunningComp?page=1"><i class="icon fa fa-circle-o"></i>正在进行中的竞赛</a></li>
            <li><a class="treeview-item" href="showEndComp?page=1"><i class="icon fa fa-circle-o"></i> 已经结束的竞赛</a></li>          
          </ul>
        </li>
        <li class="treeview"><a class="app-menu__item" href="javascript:;" data-toggle="treeview"><i class="app-menu__icon fa fa-edit"></i><span class="app-menu__label">竞赛管理</span><i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul>
            <li><a class="treeview-item" href="showMyAplComp"><i class="icon fa fa-circle-o"></i>报名中的竞赛</a></li>
            <li><a class="treeview-item" href="showMyRunComp"><i class="icon fa fa-circle-o"></i>正在进行中的竞赛</a></li>
            <li><a class="treeview-item" href="showMyEndComp"><i class="icon fa fa-circle-o"></i>已经结束的竞赛</a></li>
          </ul>
        </li>
        <li class="treeview"><a class="app-menu__item" href="javascript:;" data-toggle="treeview"><i class="app-menu__icon fa fa-th-list"></i><span class="app-menu__label">个人信息管理</span><i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul>
            <li><a class="treeview-item" href="EdtInfo.action"><i class="icon fa fa-circle-o"></i>编辑个人信息</a></li>
            <li><a class="treeview-item" href="<%=basePath%>stuUI/modifyPassword.jsp"><i class="icon fa fa-circle-o"></i>修改密码</a></li>
          </ul>
        </li>
        <li class="treeview"><a class="app-menu__item" href="javascript:;" data-toggle="treeview"><i class="app-menu__icon fa fa-file-text"></i><span class="app-menu__label">团队管理</span><i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul>
            <li><a class="treeview-item" href="<%=basePath%>stuUI/teamCreat.jsp"><i class="icon fa fa-circle-o"></i> 新建团队</a></li>
            <li><a class="treeview-item" href="showMyTeams.action?page=1"><i class="icon fa fa-circle-o"></i> 管理参与的团队</a></li>
            <li><a class="treeview-item" href="showTeams.action?page=1"><i class="icon fa fa-circle-o"></i>团队列表</a></li>           
          </ul>
        </li>
      </ul>
    </aside>