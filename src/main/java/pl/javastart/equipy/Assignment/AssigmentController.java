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
    private final AssigmentRepository assigmentRepository;

    public AssigmentController(AssigmentService assigmentService, AssigmentRepository assigmentRepository) {
        this.assigmentService = assigmentService;
        this.assigmentRepository = assigmentRepository;
    }

    @PostMapping("/api/assignments")
    public AssigmentRequest save(@RequestBody AssigmentRequest assigmentRequest){
        return assigmentService.save(assigmentRequest);
    }

    @PostMapping("/api/assignments/{assignmentId}/end")
    public ResponseEntity<LocalDateTime> end(@PathVariable Long assignmentId){
        Assignment assignmentFound = assigmentRepository.findById(assignmentId).orElseThrow();
        if (assignmentFound.getEndTime() !=null) {
            throw new AlreadyEnded();
        }else {
            Assignment assignment = assigmentService.endAssigment(assignmentId);
            return new ResponseEntity<>(assignment.getEndTime(), HttpStatus.OK);
        }
    }
}
