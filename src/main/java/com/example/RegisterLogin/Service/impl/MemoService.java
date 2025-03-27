package com.example.RegisterLogin.Service.impl;


import com.example.RegisterLogin.Entity.Memo;
import com.example.RegisterLogin.Repo.MemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService {
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository){
        this.memoRepository = memoRepository;
    }
    public List<Memo> getMemo(){
        return memoRepository.findAll();
    }
    public Memo getMemo(Long id) {return memoRepository.findById(id).orElse(null);}

    public Memo addMemo(Memo memo) {return memoRepository.save(memo);}

    public Memo updateMemo(Memo memo) {return memoRepository.save(memo);}

    public void deleteMemo(Long id) {memoRepository.deleteById(id);}

}

