# get

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET</title>
</head>
<body>
	<form action = "result_study" method = "get">
	이름 : <input name = "user_name"> <br/>
	나이 : <input type = "number" name = "user_age"> <br/>
	<button>제출</button>
	
	</form>

</body>
</html>
```

# post

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET</title>
</head>
<body>
	<form action = "result_study" method = "post">
	이름 : <input name = "user_name"> <br/>
	나이 : <input type = "number" name = "user_age"> <br/>
	<button>제출</button>
	
	</form>

</body>
</html>
```

# servlet

```html
package d0705;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/0705/result_study")

public class Study01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.write("<html>"
				+ "<head><title>아 하기싫어 </title> <meta charset = \"utf-8\"/>"
				+ "</head>" + "<body>");
		pw.write("이름 : " + req.getParameter("user_name"));
		String sAge = req.getParameter("user_age");
		int age;
		if(sAge == null || sAge.isEmpty()) {
			age = 0;
		} else {
			age = Integer.parseInt(sAge);
			if(age < 0) {
				age = 0;
			}
		}
		pw.write("나이 " + age);
		pw.write("</body>");
		pw.write("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.write("<html>"
				+ "<head><title>아 하기싫어 </title> <meta charset = \"utf-8\"/>"
				+ "</head>" + "<body>");
		pw.write("이름 : " + req.getParameter("user_name"));
		String sAge = req.getParameter("user_age");
		int age;
		if(sAge == null || sAge.isEmpty()) {
			age = 0;
		} else {
			age = Integer.parseInt(sAge);
			if(age < 0) {
				age = 0;
			}
		}
		pw.write("나이 " + age);
		pw.write("</body>");
		pw.write("</html>");
	}
}

```

