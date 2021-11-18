# Basic Book finding API
#### Written with SpringBoot To express my understanding of TDD, OOP <br/> in backend developmen.t

## Brief Guide

**There are only two major endpoints, GET:all-books and POST:find-book.**  
__You need to call the GET request first so as to know which book to find. <br/> Books with availableQuantity of zero would return an unavailable response, <br/> while books that not in the MockDB would return a custom exception.__

__There is no Websecurity setup currently, therefore no form of authentication and <br/> authorization exists, however a swagger-ui tests lives on this route: <br/> {localhost]/swagger-ui/__
