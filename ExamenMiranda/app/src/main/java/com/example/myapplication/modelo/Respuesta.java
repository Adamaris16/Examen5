package com.example.myapplication.modelo;

import java.util.List;

public class Respuesta {
    public List<Persona> results;
    public Info info;

    public class Info {
        String seed;
        int results;
        int page;
        String version;

        public Info() {
        }

        public Info(String seed, int results, int page, String version) {
            this.seed = seed;
            this.results = results;
            this.page = page;
            this.version = version;
        }

        public String getSeed() {
            return seed;
        }

        public void setSeed(String seed) {
            this.seed = seed;
        }

        public int getResults() {
            return results;
        }

        public void setResults(int results) {
            this.results = results;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }


    public Respuesta() {
    }

    public Respuesta(List<Persona> results, Info info) {
        this.results = results;
        this.info = info;
    }

    public List<Persona> getResults() {
        return results;
    }

    public void setResults(List<Persona> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
