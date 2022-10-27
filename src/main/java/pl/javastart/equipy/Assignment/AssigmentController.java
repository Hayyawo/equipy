package pl.javastart.equipy.Assignment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class AssigmentController {
    private final AssigmentService assigmentService;

    public AssigmentController(AssigmentService assigmentService) {
        this.assigmentService = assigmentService;
    }

    @PostMapping("/api/assignments")
    public AssigmentRequest save(@RequestBody AssigmentRequest assigmentRequest){
        return assigmentService.save(assigmentRequest);
    }

    @PostMapping("/api/assignments/{assignmentId}/end")
    public ResponseEntity<LocalDateTime> end(@PathVariable Long assignmentId){
        Assignment assignment = assigmentService.endAssigment(assignmentId);
        return new ResponseEntity<>(assignment.getEndTime(), HttpStatus.OK);
    }
}
