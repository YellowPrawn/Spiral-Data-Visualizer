library(tidyverse)
library(here)
library(lubridate)
library(dplyr)
library(ggplot2)

outline_color <- "#D97C86"
fill_color <- "#F0C0C1"
base_grey <- "grey28"
size_factor <- 10000
options(repr.plot.width = 10, repr.plot.height = 10)
month_length <- c(31, 28, 31, 30, 31, 30,
                  31, 31, 30, 31, 30, 31) # the length of each month enumurated
month_breaks <- cumsum(month_length) - 30
year_annotations <- list(
  year = 2020:2022,
  x = rep(3, 3),
  y = as.POSIXct(paste(2020:2022, "01", "01", sep = "-"))
)


#TODO generalize this and enumerate for each province url
data <- read.csv("http://www.bccdc.ca/Health-Info-Site/Documents/BCCDC_COVID19_Dashboard_Case_Details.csv")



daily_data <- data %>%
  count(Reported_Date) %>%
  group_by(Reported_Date) %>%
  mutate(day_of_year = yday(Reported_Date),
         year = year(Reported_Date))


size_factor <- 10000
options(repr.plot.width = 10, repr.plot.height = 10)

# Colors
outline_color <- "#D97C86"
fill_color <- "#F0C0C1"
base_grey <- "grey28"

data_plot <- daily_data %>%
  ggplot() +
  # area to encode the number of cases
  geom_ribbon(aes(x = day_of_year,
                  ymin = as.POSIXct(Reported_Date) - n / 2 * size_factor,
                  ymax = as.POSIXct(Reported_Date) + n / 2 * size_factor,
                  group = year),
              size = 0.3, col = outline_color, fill = fill_color, show.legend = FALSE) +
  # basic line
  geom_segment(aes(x = day_of_year, xend = day_of_year + 1,
                   y = as.POSIXct(Reported_Date), yend = as.POSIXct(Reported_Date)),
               col = base_grey, size = 0.3) +
  coord_polar() +
  theme_void() +
  scale_x_continuous(minor_breaks = month_breaks,
                     breaks = month_breaks[c(1, 4, 7, 10)],
                     labels = c("Jan.", "April", "July", "Oct.")) +
  theme(plot.background = element_rect(color = NA, fill = "white"),
        panel.grid.major.x = element_line(color = "grey70", size = 0.8, linetype = "dotted"),
        panel.grid.minor.x = element_line(color = "grey70", size = 0.8, linetype = "dotted"),
        axis.text.x = element_text(color = base_grey, size = 10, hjust = 0.5),) +
  annotate("text", label = paste0(year_annotations$year, "\u2192"), x = year_annotations$x,
           y = year_annotations$y,
           size = 3, vjust = -0.6, hjust = 0.15)
ggsave("data/plot.png", width = 10, height = 10)
