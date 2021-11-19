package com.urunner.khweb.repository.board;

import com.urunner.khweb.entity.lecture.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CallLectureRepository extends JpaRepository<Lecture, Long> {

//    @Query(value = "select * from lecture inner join member on lecture.writer = member.email join category_lecture on lecture.lecture_id = category_lecture.lecture_id where category_lecture.category_id = :categoryId", nativeQuery = true)
//    List<Object[]> selectLectureListWithTag(Long categoryId);

    @Query(value = "select title, price, grade, nickname, thumb_path, writer from lecture inner join member on lecture.writer = member.email join category_lecture on lecture.lecture_id = category_lecture.lecture_id where category_lecture.category_id = :categoryId and lecture.in_progress = 1", nativeQuery = true)
    List<Object[]> selectLectureListWithTag(Long categoryId);

    @Query(value = "select title, price, grade, nickname, thumb_path, writer from lecture inner join member on lecture.writer = member.email where lecture.in_progress = 1 and lecture.title like %:word% ", nativeQuery = true)
    List<Object[]> selectLectureListWithWord(String word);

    @Query(value = "select title, price, grade, nickname, thumb_path, writer from lecture inner join member on lecture.writer = member.email where lecture.in_progress = 1", nativeQuery = true)
    List<Object[]> selectLectureList();
}