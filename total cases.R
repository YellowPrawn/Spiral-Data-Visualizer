library(tidyverse)
library(dplyr)

data <- read.csv("https://health-infobase.canada.ca/src/data/covidLive/covid19-download.csv")

total_ca <- filter(data, prname == "Canada")
sum_ca <- sum(total_ca$numtoday)

total_bc <- filter(data, prname == "British Columbia")
sum_bc <- sum(total_bc$numtoday)

total_alberta <- filter(data, prname == "Alberta")
sum_alberta <- sum(total_alberta$numtoday)

total_sas <- filter(data, prname == "Saskatchewan")
sum_sas <- sum(total_sas$numtoday)

total_manitoba <- filter(data, prname == "Manitoba")
sum_manitoba <- sum(total_manitoba$numtoday)

total_ontario <- filter(data, prname == "Ontario")
sum_ontario <- sum(total_ontario$numtoday)

total_quebec <- filter(data, prname == "Quebec")
sum_quebec <- sum(total_quebec$numtoday)

total_nl <- filter(data, prname == "Newfoundland and Labrador")
sum_nl <- sum(total_nl$numtoday)

total_brun <- filter(data, prname == "New Brunswick")
sum_brun <- sum(total_brun$numtoday)

total_ns <- filter(data, prname == "Nova Scotia")
sum_ns <- sum(total_ns$numtoday)

total_pei <- filter(data, prname == "Prince Edward Island")
sum_pei <- sum(total_pei$numtoday)

total_yukon <- filter(data, prname == "Yukon")
sum_yukon <-sum(total_yukon$numtoday)

total_nt <- filter(data, prname == "Northwest Territories")
sum_nt <- sum(total_nt$numtoday)

total_nunavut <- filter(data, prname == "Nunavut")
sum_nunavut <- sum(total_nunavut$numtoday)


provinces <- c("Canada", "British Columbia", "Alberta", "Saskatchewan", "Manitoba", "Ontario", "Quebec", "Newfoundland and Labrador", "New Brunswick", "Nova Scotia", "Prince Edward Island", "Yukon", "Northwest Territories", "Nunavut")
province_sum <- c(sum_ca, sum_bc, sum_alberta, sum_sas, sum_manitoba, sum_ontario, sum_quebec, sum_nl, sum_brun, sum_ns, sum_pei, sum_yukon, sum_nt, sum_nunavut)

df <- data.frame(provinces, province_sum)
df

setwd("~/git/Spiral-Data-Visualizer/data")
write.csv(df, "Total Provincial COVID Cases.csv", row.names = F)