package friends.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import friends.dao.FriendDao;

@WebServlet("/delete")
public class FriendDeleteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		boolean flag = FriendDao.getInstance().delete(num);
		
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
		pw.println("<title>삭제 알림</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<script>");
		if(flag) {
			pw.println("alert('삭제되었습니다.');");
		}else {
			pw.println("alert('회원정보 삭제가 실패했습니다.');");
		}
		pw.println("location.href='search';");
		pw.println("</script>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
