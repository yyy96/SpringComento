package com.devfun.service;
import java.util.List;
import com.devfun.vo.MovieVO;
 
// 비즈니스 로직을 작성하는 곳. DB처리시 이용
public interface MovieService {
    public List<MovieVO> selectMovie() throws Exception;
}