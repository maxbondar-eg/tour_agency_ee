package ua.training;

import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class MainServletTest {

    @Test
    public void mainServletCall() throws ServletException, IOException {
        Servlet servlet = new Servlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/index.jsp")).thenReturn(dispatcher);
        when(request.getRequestURI()).thenReturn("/controller");

        servlet.init();
        servlet.doGet(request, response);

        verify(request, times(1)).getRequestDispatcher("/index.jsp");
        verify(response, never()).sendRedirect("/controller");
    }

}
