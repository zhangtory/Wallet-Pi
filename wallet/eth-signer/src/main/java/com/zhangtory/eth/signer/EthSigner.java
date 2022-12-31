package com.zhangtory.eth.signer;

import com.zhangtory.wallet.core.interfaces.signature.Signer;
import com.zhangtory.wallet.core.model.entity.Address;
import com.zhangtory.wallet.core.model.vo.signature.SignParams;
import com.zhangtory.wallet.core.model.vo.signature.SignedData;
import lombok.extern.slf4j.Slf4j;
import org.bitcoinj.crypto.ChildNumber;
import org.bitcoinj.crypto.DeterministicHierarchy;
import org.bitcoinj.crypto.DeterministicKey;
import org.bitcoinj.crypto.HDKeyDerivation;
import org.bitcoinj.crypto.HDPath;
import org.bitcoinj.crypto.MnemonicCode;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.stereotype.Service;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.utils.Numeric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangtory
 * @date 2022/10/7 20:45
 * @description:
 */
@Service
@Slf4j
public class EthSigner implements Signer {

    private static final String PARENT_PATH = "m/44H/60H/0H/0";

    /**
     * 创建一个新的账户
     *
     * @param seed
     * @return address
     */
    @Override
    public Address createAddress(byte[] seed) {
        ECKeyPair ecKeyPair = ECKeyPair.create(seed);
        String publicKey = ecKeyPair.getPublicKey().toString(16);
        String address = Numeric.prependHexPrefix(Keys.getAddress(ecKeyPair));
        return Address.builder().publicKey(publicKey).address(address).build();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("nothing");
        list.add("sustain");
        list.add("toy");
        list.add("garbage");
        list.add("float");
        list.add("forum");
        list.add("fog");
        list.add("gap");
        list.add("table");
        list.add("cool");
        list.add("decade");
        list.add("century");
        list.add("game");
        list.add("smooth");
        list.add("regular");
        list.add("donkey");
        list.add("height");
        list.add("into");
        list.add("fashion");
        list.add("fiscal");
        list.add("swarm");
        list.add("nation");
        list.add("snack");
        list.add("crucial");
        byte[] seed = MnemonicCode.toSeed(list, "");
        System.out.println(Hex.toHexString(seed));
        DeterministicKey masterKey = HDKeyDerivation.createMasterPrivateKey(seed);
        DeterministicHierarchy masterDH = new DeterministicHierarchy(masterKey);

        String path = "m/44H/60H/0H/0";
        List<ChildNumber> parentPath = HDPath.parsePath(path);
        ChildNumber childNumber = new ChildNumber(0);
        DeterministicKey deterministicKey = masterDH.deriveChild(parentPath, false, true, childNumber);

        ECKeyPair ecKeyPair = ECKeyPair.create(deterministicKey.getPrivKeyBytes());
        String address = Keys.getAddress(ecKeyPair);
        System.out.println(address);
    }

    /**
     * 交易签名
     *
     * @param signParams
     * @return
     */
    @Override
    public SignedData sign(SignParams signParams) {
        return null;
    }

    /**
     * 获取bip44 path
     *
     * @return
     */
    @Override
    public String getParentPath() {
        return PARENT_PATH;
    }

}
