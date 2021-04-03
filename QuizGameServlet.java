package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QuizGameServlet")
public class QuizGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private int nOCA = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] question = {"Q1", "Q2", "Q3", "Q4", "Q5"};
		if(count <= question.length - 1) {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset = \"UTF-8\">");
		out.println("<title>クイズゲーム</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action = \"/QuizGame/QuizGameServlet\" method = \"post\">");
		out.println("<p>問題:" + question[count] + "</p>");
		out.println("<input type = \"text\" name = \"inputAnswer\"><br>");
		out.println("<input type = \"submit\" value = \"答える\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		} else if(count > question.length - 1) {
			response.setContentType("text/html; charset = UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset = \"UTF-8\">");
			out.println("<title>クイズゲーム終了！！</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("お疲れさまでした。<br>");
			out.println(nOCA + "問正解ですね<br>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result;
		String[] currentAnswer = {"A1", "A2", "A3", "A4", "A5"};

		request.setCharacterEncoding("UTF-8");
		String inputAnswer = request.getParameter("inputAnswer");

		if(inputAnswer.equals(currentAnswer[count])) {
			result = "正解です。答えは" + inputAnswer + "であっています。";
			nOCA++;
		} else {
			result = "不正解です。答えは" + currentAnswer[count] + "でした。";
		}

		count++;

		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset = \"UTF-8\">");
		out.println("<title>クイズゲーム</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + result + "</p>");
		out.println("<form action = \"/QuizGame/QuizGameServlet\" method = \"get\">");
		out.println("<input type = \"submit\" value = \"次の問題へ\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

}
