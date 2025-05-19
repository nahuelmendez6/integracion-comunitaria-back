package com.programmingIII.ProgrammingTP1.dto;

public class AvailabilityDTO {
    private int idAvailability;
    private HourDTO fromHour;
    private HourDTO untilHour;
    private WeekDTO week;
    private ProviderDTO provider;

    public AvailabilityDTO() {
    }

    public AvailabilityDTO(int idAvailability, HourDTO fromHour, HourDTO untilHour, WeekDTO week, ProviderDTO provider) {
        this.idAvailability = idAvailability;
        this.fromHour = fromHour;
        this.untilHour = untilHour;
        this.week = week;
        this.provider = provider;
    }

    public static class HourDTO {
        private Integer idHour;
        private String name;

        // Getters y Setters

        public Integer getIdHour() {
            return idHour;
        }

        public void setIdHour(Integer idHour) {
            this.idHour = idHour;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class WeekDTO {
        private Integer idWeek;
        private String name;

        // Getters y Setters

        public Integer getIdWeek() {
            return idWeek;
        }

        public void setIdWeek(Integer idWeek) {
            this.idWeek = idWeek;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ProviderDTO {
        private Integer idProvider;
        private String name;

        // Getters y Setters

        public Integer getIdProvider() {
            return idProvider;
        }

        public void setIdProvider(Integer idProvider) {
            this.idProvider = idProvider;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public int getIdAvailability() {
        return idAvailability;
    }

    public void setIdAvailability(int idAvailability) {
        this.idAvailability = idAvailability;
    }

    public HourDTO getFromHour() {
        return fromHour;
    }

    public void setFromHour(HourDTO fromHour) {
        this.fromHour = fromHour;
    }

    public HourDTO getUntilHour() {
        return untilHour;
    }

    public void setUntilHour(HourDTO untilHour) {
        this.untilHour = untilHour;
    }

    public WeekDTO getWeek() {
        return week;
    }

    public void setWeek(WeekDTO week) {
        this.week = week;
    }

    public ProviderDTO getProvider() {
        return provider;
    }

    public void setProvider(ProviderDTO provider) {
        this.provider = provider;
    }
}