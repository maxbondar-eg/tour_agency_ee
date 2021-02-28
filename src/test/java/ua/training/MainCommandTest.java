package ua.training;

import org.junit.Assert;
import org.junit.Test;
import ua.training.command.MainPageCommand;
import ua.training.service.TourService;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.mock;

public class MainCommandTest {

    @Test
    public void mainTest(){
        MainPageCommand command = new MainPageCommand();
        TourService tourService = mock(TourService.class);
        HttpServletRequest request = mock(HttpServletRequest.class);


        Assert.assertEquals("/index.jsp", command.execute(request));


    }
}
