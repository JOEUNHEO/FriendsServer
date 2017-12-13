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

@WebServlet("/update")
public class FriendUpdateServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String regdate = request.getParameter("regdate");
		
		FriendDto dto = new FriendDto(num, name, phone, regdate);
		boolean flag = FriendDao.getInstance().update(dto);
		
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
		pw.println("<title></title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<script>");
		if(flag) {
			pw.println("alert('수정되었습니다.');");
		}else {
			pw.println("alert('수정이 실패했습니다.);");
		}
		pw.println("location.href='search';");
		pw.println("</script>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
