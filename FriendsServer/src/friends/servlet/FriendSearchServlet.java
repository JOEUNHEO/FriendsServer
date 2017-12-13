package friends.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import friends.dao.FriendDao;
import friends.dto.FriendDto;

@WebServlet("/search")
public class FriendSearchServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FriendDto> list = FriendDao.getInstance().getList();
		
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
		pw.println("<title>회원 정보</title>");
		pw.println("<style>");
		pw.println("a, a:link{");
		pw.println("text-decoration:none;");
		pw.println("color:inherit;");
		pw.println("}");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<button><a href='/FriendsServer/'>회원 정보 저장</a></button>");
		pw.println("<fieldset>");
		pw.println("<table>");
		pw.println("<caption>Friends 회원 정보 내역</caption>");
		pw.println("<thead>");
		pw.println("<tr>");
		pw.println("<th>번호</th>");
		pw.println("<th>이름</th>");
		pw.println("<th>핸드폰</th>");
		pw.println("<th>날짜</th>");
		pw.println("<th>삭제</th>");
		pw.println("<th>수정</th>");
		pw.println("</tr>");
		pw.println("</thead>");
		pw.println("<tbody>");
		for(FriendDto tmp:list) {
			pw.println("<tr>");
			pw.println("<td>"+tmp.getNum()+"</td>");
			pw.println("<td>"+tmp.getName()+"</td>");
			pw.println("<td>"+tmp.getPhone()+"</td>");
			pw.println("<td>"+tmp.getRegDate()+"</td>");
			pw.println("<td><button><a href='delete?num="+tmp.getNum()+"'>삭제</a></button></td>");
			pw.println("<td><button><a href='updateform?num="+tmp.getNum()+"'>수정</a></button></td>");
		}
		pw.println("</tbody>");
		pw.println("</table>");
		pw.println("</fieldset>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
