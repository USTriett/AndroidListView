package com.example.mylistview;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokeInfo {
    private int id;
    private Name name;
    private List<String> type;
    private BaseStats base;

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public List<String> getType() {
        return type;
    }

    public BaseStats getBase() {
        return base;
    }

    public static class Name {
        private String english;
        private String japanese;
        private String chinese;
        private String french;

        public String getEnglish() {
            return english;
        }

        public String getJapanese() {
            return japanese;
        }

        public String getChinese() {
            return chinese;
        }

        public String getFrench() {
            return french;
        }
    }

    public static class BaseStats {
        private int HP;
        private int Attack;
        private int Defense;
        private int SpAttack;
        private int SpDefense;
        private int Speed;

        public void setSpAttack(int spAttack) {
            SpAttack = spAttack;
        }

        public void setSpDefense(int spDefense) {
            SpDefense = spDefense;
        }

        public int getHP() {
            return HP;
        }

        public int getAttack() {
            return Attack;
        }

        public int getDefense() {
            return Defense;
        }

        public int getSpAttack() {
            return SpAttack;
        }

        public int getSpDefense() {
            return SpDefense;
        }

        public int getSpeed() {
            return Speed;
        }
    }


}
