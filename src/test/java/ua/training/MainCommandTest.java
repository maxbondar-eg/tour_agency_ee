package ua.training;

import org.junit.Assert;
import org.junit.Test;
import ua.training.command.MainPageCommand;
import ua.training.model.Tour;
import ua.training.service.TourService;

import javax.servlet.http.HttpServletRequest;

import java.util.*;

import static org.mockito.Mockito.*;

public class MainCommandTest {

    @Test
    public void mainTest(){
        MainPageCommand command = new MainPageCommand();
        TourService tourService = mock(TourService.class);
        HttpServletRequest request = mock(HttpServletRequest.class);


        Assert.assertEquals("/index.jsp", command.execute(request));


    }
}
