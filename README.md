# Mobilny Kalendarz WEEIA
API, które generuje dla wybranego miesiąca kalendarz w formacie ICS/iCal dla kalendarza ze strony http://www.weeia.p.lodz.pl.

# Zapytanie
Podajemy rok i miesiąc jako parametry:
```
/api/calendar/{year}/{month}
```
{year} - rok, dla którego chcemy wygnerować kalendarz,
{month} - miesiąc, dla którego chcemy wygnerować kalendarz

Przykład z właściwymi parametrami: 
```
/api/calendar/2020/10
```
Należy pamiętać o tym, że  miesiące będacy jedną cyfrą należy poprzedzić cyfrą 0. Dla przykładu dla marca musimy podać 03. Poniżej przykład:
```
/api/calendar/2020/03
```

# Odpowiedź
Odpowiedź to wygenerowany plik w formacie .ics, w którym zapisane sa wydarzenia z miesiąca i roku, które zostały podane jako parametry. Wydarzenia te zostały pobrane z kalenadarza ze strony http://www.weeia.p.lodz.pl. 



