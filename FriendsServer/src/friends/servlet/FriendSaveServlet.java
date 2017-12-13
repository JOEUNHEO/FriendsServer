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

@WebServlet("/save")
public class FriendSaveServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST 방식 전송 인코딩 설정(한글깨지지 않도록)
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
				
		System.out.println(name);
		System.out.println(phone);
		FriendDto dto = new FriendDto();
		dto.setName(name);
		dto.setPhone(phone);
		
		FriendDao dao = FriendDao.getInstance();
		boolean flag = dao.insert(dto);
		
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
			pw.println("alert('회원정보를 저장했습니다.');");
		}else {
			pw.println("alert('회원정보 저장에 실패했습니다.');");
		}
		pw.println("location.href='search';");
		pw.println("</script>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
