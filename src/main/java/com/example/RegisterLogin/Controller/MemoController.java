package com.example.RegisterLogin.Controller;

import com.example.RegisterLogin.Entity.Memo;
import com.example.RegisterLogin.Service.impl.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemoController {

    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService){
        this.memoService = memoService;
    }
    @GetMapping("/memos")
    @CrossOrigin
    public List<Memo> getMemo(){
        return memoService.getMemo();
    }
    @GetMapping("/memo/{id}")
    public Memo getMemo(@PathVariable("id") Long id) {return memoService.getMemo(id);}

    @PutMapping("/memo/{id}")
    @CrossOrigin
    public Memo updateMemo(@RequestBody() Memo memo, @PathVariable("id") Long id){
        return memoService.updateMemo(memo);
    }
    @PostMapping("/memos")
    @CrossOrigin
    public ResponseEntity<Memo> addNew(@RequestBody() Memo memo){
        Memo newmemo = memoService.addMemo(memo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newmemo);
    }
    @DeleteMapping("/memo/{id}")
    @CrossOrigin
    public void deleteMemo(@PathVariable("id") long id){memoService.deleteMemo(id);}

}