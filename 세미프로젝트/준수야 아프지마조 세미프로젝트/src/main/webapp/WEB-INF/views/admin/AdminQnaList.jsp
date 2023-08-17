<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AdminQnaList</title>

    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
    crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/AdminQnaList.css">
</head>
<body>

    

    <header>
        헤더
    </header>

    <div id="k-qList-content">

        <div class="k-slide">
            <ul class="k-sidebar">
                <li><a href="#">공지사항</a></li>
                <li><a href="#">QnA</a></li>
                <li><a href="#">별점후기</a></li>
            </ul>
        </div>

        <div class="k-qna">


            <div>FAQ</div>

            <div class="k-faq"> <!-- faq -->
                
                <div class="k-faq-slide">
                    <span>첫 번째</span>
                    <div class="k-arrow-img"></div>
                    <!-- <img src="../images/arrow_down.png" class="k-arrow"> -->
                </div>
                <div  class="k-faq-content">
                    <div>
                        안녕하세오 <br>
                        overflow가 안 먹어요
                        <br>
                        그리고 음..pre를 안 넣어도 잘 넘어갈지 모르겠어요
                        <br>
                        관리자 증말 zzㅏ증나 <br><br>sdfkl
                        ssafd
                        <br>
                        dfsa
                    </div>
                    <div class="k-btns">
                        <button type="button" class="k-mod-btn">수정</button>
                        <button type="button" class="k-del-btn">삭제</button>
                    </div>
                </div>
                <div class="k-faq-slide">
                    <span>두 번째</span>
                    <div class="k-arrow-img"></div>
                    <!-- <img src="../images/arrow_down.png" class="k-arrow"> -->
                </div>
                <div  class="k-faq-content">
                    <div>
                        안녕하세오 <br>
                        overflow가 안 먹어요
                        <br>
                        그리고 음..pre를 안 넣어도 잘 넘어갈지 모르겠어요
                        <br>
                        관리자 증말 zzㅏ증나 <br><br>sdfkl
                        ssafd
                        <br>
                        dfsa
                    </div>
                    <div class="k-btns">
                        <button type="button" class="k-mod-btn">수정</button>
                        <button type="button" class="k-del-btn">삭제</button>
                    </div>
                </div>
                <div class="k-faq-slide">
                    <span>세 번째</span>
                    <div class="k-arrow-img"></div>
                    <!-- <img src="../images/arrow_down.png" class="k-arrow"> -->
                </div>
                <div  class="k-faq-content">
                    <div>
                        안녕하세오 <br>
                        overflow가 안 먹어요
                        <br>
                        그리고 음..pre를 안 넣어도 잘 넘어갈지 모르겠어요
                        <br>
                        관리자 증말 zzㅏ증나 <br><br>sdfkl
                        ssafd
                        <br>
                        dfsa
                    </div>
                    <div class="k-btns">
                        <button type="button" class="k-mod-btn">수정</button>
                        <button type="button" class="k-del-btn">삭제</button>
                    </div>
                </div>
                <div class="k-faq-slide">
                    <span>네 번째</span>
                    <div class="k-arrow-img"></div>
                    <!-- <img src="../images/arrow_down.png" class="k-arrow"> -->
                </div>
                <div  class="k-faq-content">
                    <div>
                        안녕하세오 <br>
                        overflow가 안 먹어요
                        <br>
                        그리고 음..pre를 안 넣어도 잘 넘어갈지 모르겠어요
                        <br>
                        관리자 증말 zzㅏ증나 <br><br>sdfkl
                        ssafd
                        <br>
                        dfsa
                    </div>
                    <div class="k-btns">
                        <button type="button" class="k-mod-btn">수정</button>
                        <button type="button" class="k-del-btn">삭제</button>
                    </div>
                </div>
               
                
                
                
            

            </div>

            
            <div>질문게시판</div>
            
            <div>
                <button id="q-btn">게시글 작성</button>
            </div>

            <div> <!-- 질문게시판 목록 -->
                <a href="#" style="text-decoration: none;">
                    <div class="k-q-list">
                        <div>1</div>
                        <div>제목</div>
                        <div></div>
                        <div>작성자</div>
                        <div>2023-05-31</div>
                    </div>
                    <div class="k-q-list">
                        <div>2</div>
                        <div>제목</div>
                        <div></div>
                        <div>작성자</div>
                        <div>2023-05-31</div>
                    </div>
                    <div class="k-q-list">
                        <div>3</div>
                        <div>제목</div>
                        <div></div>
                        <div>작성자</div>
                        <div>2023-05-31</div>
                    </div>
                    <div class="k-q-list">
                        <div>4</div>
                        <div>제목</div>
                        <div></div>
                        <div>작성자</div>
                        <div>2023-05-31</div>
                    </div>
                    <div class="k-q-list">
                        <div>5</div>
                        <div>제목</div>
                        <div></div>
                        <div>작성자</div>
                        <div>2023-05-31</div>
                    </div>
                </a>
            </div>

            <nav aria-label="Page navigation example" class="k-pg">
                <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                </ul>
            </nav>

            <div class="k-search-div"> <!-- 하단 검색 부분 -->
                <div>
                    <button type="button" id="k-search-btn">검색</button>
                </div>
                <div>
                    <select name="k-search" id="k-search">
                        <option value="1">제목 + 내용</option>
                        <option value="2">제목</option>
                        <option value="3">내용</option>
                    </select>
                </div>
                <div><input type="search" name="k-search" id="k-search"></div>
                <div><img src="resources/images/search.png"></div>
            </div>


        </div>
    

        
    </div>

    

    <footer>
        푸터
    </footer>
      
    

      
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"
        integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <script src="resources/js/AdminQnaList.js"></script>
</body>
</html>