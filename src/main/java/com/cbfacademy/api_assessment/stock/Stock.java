package com.cbfacademy.api_assessment.stock;

public class Stock {
        private String stockSymbol;
        private String exchange;
        private String companyName;

public Stock(){};


public Stock(String stockSymbol, String exchange, String companyName){
     this.stockSymbol = stockSymbol;
     this.exchange = exchange;
     this.companyName = companyName;
}

public String getStockSymbol(){
        return stockSymbol;   
    }

    public String getExchange(){
        return exchange;   
    }

    public String getCompanyName(){
        return companyName;   
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;   
    }

    public void setStockSymbol(String stockSymbol){
        this.stockSymbol = stockSymbol;   
    }

     public void setExchange(String exchange){
        this.exchange = exchange;   
    }

}
