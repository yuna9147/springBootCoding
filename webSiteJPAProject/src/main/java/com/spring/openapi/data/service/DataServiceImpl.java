package com.spring.openapi.data.service;

import com.spring.common.openapi.URLConnectUtil;
import com.spring.openapi.data.dto.OpenApiDTO;
import com.spring.openapi.data.vo.AnimalDaejeonDTO;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {
    private final String serviceKey = "035bf9883b6516d3ec7e443705bfd30cca9bffcb8988350bdd5d5f78e4a17ab0";

    @Override
    public String busanWalkingList() {
        try {
            String baseUrl = "http://apis.data.go.kr/6260000/WalkingService/getWalkingKr";
            String params = String.format("?serviceKey=%s&pageNo=1&numOfRows=12&resultType=json", serviceKey);
            String site = baseUrl + params;

            OpenApiDTO openApi = new OpenApiDTO(site, "GET");
            return URLConnectUtil.openAPIData(openApi).toString();
        } catch (Exception e) {
            return "API 호출 중 오류 발생";
        }
    }

    @Override
    public String busanWalkingDetail(String seq) {
        try {
            String baseUrl = "http://apis.data.go.kr/6260000/WalkingService/getWalkingKr";
            String params = String.format("?serviceKey=%s&pageNo=1&numOfRows=12&resultType=json&UC_SEQ=%s", serviceKey, seq);
            String site = baseUrl + params;

            OpenApiDTO openApi = new OpenApiDTO(site, "GET");
            return URLConnectUtil.openAPIData(openApi).toString();
        } catch (Exception e) {
            return "API 호출 중 오류 발생";
        }
    }

    // 요청 url: http://localhost:8080/data/animalDaejeonList?searchCondition=1&searchCondition3=1
    @Override
    public String animalDaejeonList(AnimalDaejeonDTO animalDaejeonDTO) {
        try {
            StringBuilder site = getAnimalDaejeonData(animalDaejeonDTO);

            OpenApiDTO openApi = new OpenApiDTO(site.toString(), "GET");
            return URLConnectUtil.openAPIData(openApi).toString();
        } catch (Exception e) {
            return "API 호출 중 오류 발생";
        }
    }


    private StringBuilder getAnimalDaejeonData(AnimalDaejeonDTO animalDaejeonDTO) {
        StringBuilder site = new StringBuilder("http://apis.data.go.kr/6300000/animalDaejeonService/animalDaejeonList");
        site.append("?serviceKey="+serviceKey);
        site.append("&pageNo=1");
        site.append("&numOfRows=10");
        site.append("&searchCondition=" + animalDaejeonDTO.getSearchCondition());
        site.append("&searchCondition3="+animalDaejeonDTO.getSearchCondition3());

        //한글로 받아올 때는 아래처럼 인코딩 필요.
        //site.append("&searchKeyword=" + URLEncoder.encode("동물종구분", "UTF-8")); // 검색키워드 - 옵션(동물종구분,기타사항,등록번호등 검색키워드로 검색)
        return site;
    }

    // 요청 url: http://localhost:8080/data/animalDaejeonItem?animalSeq=44348
    @Override
    public String animalDaejeonItem(AnimalDaejeonDTO animalDaejeonDTO)  {
        try {
            String baseUrl = "http://apis.data.go.kr/6300000/animalDaejeonService/animalDaejeonItem";
            String params = String.format("?serviceKey=%s&animalSeq=%s", serviceKey, animalDaejeonDTO.getAnimalSeq());
            String site = baseUrl + params;

            OpenApiDTO openApi = new OpenApiDTO(site, "GET");
            return URLConnectUtil.openAPIData(openApi).toString();
        } catch (Exception e) {
            return "API 호출 중 오류 발생";
        }
    }

}
