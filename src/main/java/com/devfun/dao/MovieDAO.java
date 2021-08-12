package com.devfun.dao;
import java.util.List;
import com.devfun.vo.MovieVO;
 
// MovieVO를 담고 있는 리스트를 가지는 함수가 있는 인터페이스
public interface MovieDAO {
    public List<MovieVO> selectMovie() throws Exception;
}