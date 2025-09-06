package expense_tracker.expense_tracker.functions.sample;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sample")
public class SampleController {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    private String getSampleRequest() {
        return "SUCCESSFUL";
    }
}
