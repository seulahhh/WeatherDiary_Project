package zerobase.weather.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String weather;
    private String icon; //url로 들어옴
    private double temperature;
    private String text;
    private LocalDate date;

    /**
     * 외부 API에서 받아온 데이터 dateWeather를 기반으로
     * Diary 객체의 필드 값을 세팅하는 메서드
     * @param dateWeather
     */
    public void setDiaryValueFromDateWeather(DateWeather dateWeather) {
        this.date = dateWeather.getDate();
        this.weather = dateWeather.getWeather();
        this.icon = dateWeather.getIcon();
        this.temperature = dateWeather.getTemperature();
    }
}
