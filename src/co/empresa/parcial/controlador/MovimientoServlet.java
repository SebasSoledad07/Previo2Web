package co.empresa.parcial.controlador;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.empresa.parcial.dao.MovimientoDao;
import co.empresa.parcial.dao.UsuarioDao;
import co.empresa.parcial.modelo.Movimientos;
import co.empresa.parcial.modelo.Usuario;
import co.empresa.parcial.controlador.MovimientoServlet;

/**
 * Servlet implementation class MovimientoServlet
 */
@WebServlet("/MovimientoServlet")
public class MovimientoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private MovimientoDao movDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovimientoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
  	 * @see Servlet#init(ServletConfig)
  	 */
  	public void init(ServletConfig config) throws ServletException {
  		// TODO Auto-generated method stub
  		this.movDao = new MovimientoDao();
  		
  	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
		switch(action) {
		case "/new":
			showNewForm(request,response);
			break;
		case "/insert":
			insertarUsuario(request,response);
			break;
		case "/delete":
			eliminarUsuario(request,response);
			break;
		case "/edit":
			showEditForm(request,response);
			break;
		case "/update":
			actualizarUsuario(request,response);
			break;
		default:
			listUsuario(request,response);
			break;
		
		}
		}catch(SQLException e){
			throw new ServletException (e);
			
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

	private void listUsuario(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void showNewForm(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.html");
		dispatcher.forward(request, response);
		
	}

	private void insertarUsuario(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, SQLException,IOException{
		int valor= Integer.parseInt(request.getParameter("valor"));
		int tipo = Integer.parseInt(request.getParameter("id"));
		String descripcion = request.getParameter("descripcion");
		
		Movimientos movimiento = new Movimientos(valor,tipo,descripcion); 
		movDao.insert(movimiento);
		
		response.sendRedirect("list");
		}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		// TODO Auto-generated method stub
		int serial = Integer.parseInt(request.getParameter("serial"));
		Date fecha_mov = request.getParameter("fecha_mov";)
		Usuario usuarioActual = movDao.select(serial,fecha_mov);
		request.setAttribute("usuario", usuarioActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("movimientos.html");
		dispatcher.forward(request, response);
	}

	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException,IOException{
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		Usuario usuario = new Usuario(id,user,password,email); 
		userDao.update(usuario);
		response.sendRedirect("list");		
	}

	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException,IOException{
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		userDao.delete(id);
		response.sendRedirect("list");	
	}


}
