package api.controller;

import api.request.AccountRegistrationRequest;
import api.request.TransferRequest;
import api.response.AccountRegistrationResponse;
import api.response.TransferResponse;
import api.response.TransferResultResponse;
import api.service.BankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class BankingController {

    private final BankingService bankingService;

    @PostMapping(value = "/account")
    @ResponseBody
    public Mono<AccountRegistrationResponse> registerAccount( @RequestBody AccountRegistrationRequest request){
        return bankingService.registerAccount(request);
    }

    @PostMapping(value = "/transfer")
    @ResponseBody
    public Mono<TransferResponse> transferFunds(@RequestBody TransferRequest request){
        return bankingService.transferFunds(request);
    }

    @GetMapping(value = "/transfer/{txId}")
    @ResponseBody
    public Mono<TransferResultResponse> transferFunds(@RequestParam String txId){
        return bankingService.getTransferResult(txId);
    }

}
