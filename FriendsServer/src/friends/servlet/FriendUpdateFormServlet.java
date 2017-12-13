package friends.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import friends.dao.FriendDao;
import friends.dto.FriendDto;

@WebServlet("/updateform")
public class FriendUpdateFormServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		FriendDto dto = FriendDao.getInstance().getData(num);
		
		//응답 인코딩 설정
		response.setCharacterEncoding("utf-8");
		//응답 컨텐츠 설정
		response.setContentType("text/html;charset=utf-8");

		//클라이언트에게 문자열을 출력할 수 있는 객체 얻어오기
		PrintWriter pw = response.getWriter();
		pw.println("<!doctype hmtl>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8' />");
		pw.println("<title>수정 폼</title>");
		pw.println("<style>");
		pw.println("a, a:link{");
		pw.println("text-decoration:none;");
		pw.println("color:inherit;");
		pw.println("}");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>수정 폼 입니다.</h3>");
		pw.println("<form action='update' method='post'>");
		pw.println("<fieldset>");
		pw.println("<legend>수정할 정보 내용 입력</legend>");
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("<td><input type='hidden' name='num' value='"+dto.getNum()+"' /></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td><label for='name'>이름</label></td>");
		pw.println("<td><input type='text' name='name' value='"+dto.getName()+"' /></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td><label for='phone'>핸드폰</label></td>");
		pw.println("<td><input type='text' name='phone' value='"+dto.getPhone()+"' /></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td><label for='regdate'>날짜</label></td>");
		pw.println("<td><input type='text' name='regdate' value='"+dto.getRegDate()+"' /></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td></td>");
		pw.println("<td><button type='submit'>변경</button><button type='reset'><a href='search'>취소</a></button></td>");
		pw.println("</tr>");
		pw.println("</table>");
		pw.println("</legend>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
